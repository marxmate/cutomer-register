package input;

public enum Action {
        EXIT("exit"), UPDATE("update"), ADD("add"), DELETE("delete");

        private String value;

        Action(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

}