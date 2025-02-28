package burp;
import java.util.List;

public class KitchenSink extends ParamScan {

    KitchenSink(String name) {
        super(name);
        for (Scan scan: BulkScan.scans) {
            scanSettings.importSettings(scan.scanSettings);
        }
    }

    @Override
    List<IScanIssue> doScan(IHttpRequestResponse baseRequestResponse) {
        Utilities.out("Kicking off request scans");
        for (Scan scan: BulkScan.scans) {
            if (scan == this) {
                continue;
            }
            Utilities.out("Queueing request scan: "+scan.name);
            scan.doScan(baseRequestResponse);
        }
        return null;
    }

    @Override
    List<IScanIssue> doScan(IHttpRequestResponse baseRequestResponse, IScannerInsertionPoint insertionPoint) {
        Utilities.out("Kicking off param scans");
        for (Scan scan: BulkScan.scans) {
            if (scan instanceof ParamScan && scan != this) {
                Utilities.out("Queueing param scan: "+scan.name);
                ((ParamScan)scan).doScan(baseRequestResponse, insertionPoint);
            }
        }
        return null;
    }

    @Override
    boolean supportsRequestScan() {
        return true;
    }
}