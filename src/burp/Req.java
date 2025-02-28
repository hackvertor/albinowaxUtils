package burp;

class Req implements IHttpRequestResponse {

    private byte[] req;
    private byte[] resp;
    private IHttpService service;

    Req(byte[] req, byte[] resp, IHttpService service) {
        this.req = req;
        this.resp = resp;
        this.service = service;
    }

    @Override
    public byte[] getRequest() {
        return req;
    }

    @Override
    public void setRequest(byte[] message) {
        this.req = message;
    }

    @Override
    public byte[] getResponse() {
        return resp;
    }

    @Override
    public void setResponse(byte[] message) {
        this.resp = message;
    }

    @Override
    public String getComment() {
        return null;
    }

    @Override
    public void setComment(String comment) {

    }

    @Override
    public String getHighlight() {
        return null;
    }

    @Override
    public void setHighlight(String color) {

    }

    @Override
    public IHttpService getHttpService() {
        return service;
    }

    @Override
    public void setHttpService(IHttpService httpService) {
        this.service = httpService;
    }

//    @Override
//    public String getHost() {
//        return service.getHost();
//    }
//
//    @Override
//    public int getPort() {
//        return service.getPort();
//    }
//
//    @Override
//    public String getProtocol() {
//        return service.getProtocol();
//    }
//
//    @Override
//    public void setHost(String s) {
//
//    }
//
//    @Override
//    public void setPort(int i) {
//
//    }
//
//    @Override
//    public void setProtocol(String s) {
//
//    }
//
//    @Override
//    public URL getUrl() {
//        return Utilities.getURL(req, service);
//    }
//
//    @Override
//    public short getStatusCode() {
//        return 0;
//    }
}
