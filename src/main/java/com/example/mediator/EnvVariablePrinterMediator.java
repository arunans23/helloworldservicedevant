package com.example.mediator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;

import java.util.Map;
import java.util.TreeMap;

public class EnvVariablePrinterMediator extends AbstractMediator {

    private static final Log log = LogFactory.getLog(EnvVariablePrinterMediator.class);

    @Override
    public boolean mediate(MessageContext messageContext) {
        Map<String, String> envVars = new TreeMap<>(System.getenv());

        StringBuilder sb = new StringBuilder();
        sb.append("\n========== Environment Variables ==========\n");
        for (Map.Entry<String, String> entry : envVars.entrySet()) {
            sb.append(entry.getKey()).append(" = ").append(entry.getValue()).append("\n");
        }
        sb.append("===========================================");

        log.info(sb.toString());

        return true;
    }
}
