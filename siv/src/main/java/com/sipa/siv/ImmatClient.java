package com.sipa.siv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ImmatClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ImmatClient.class);

    public InfoImmatRep immat(String immat) {

        InfoImmatReq request = new InfoImmatReq();

        request.setImmatriculation(immat);

        /*log.info("Requesting quote for " + immat);

        InfoImmatRep response = (InfoImmatRep) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.com/stockquote.asmx", request, new SoapActionCallback("http://www.webserviceX.NET/GetQuote"));*/



        return null;
    }
}
