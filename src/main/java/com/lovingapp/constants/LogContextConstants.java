package com.lovingapp.constants;

public final class LogContextConstants {

    private LogContextConstants() {
    }

    public static final class MdcKeys {
        private MdcKeys() {
        }

        public static final String REQUEST_ID = "requestId";
        public static final String CORRELATION_ID = "correlationId";
        public static final String USER_ID = "userId";
    }

    public static final class Headers {
        private Headers() {
        }

        public static final String CORRELATION_ID = "Correlation-Id";
    }
}
