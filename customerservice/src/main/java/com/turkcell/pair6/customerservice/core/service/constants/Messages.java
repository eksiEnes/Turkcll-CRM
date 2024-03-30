package com.turkcell.pair6.customerservice.core.service.constants;

public class Messages {
    public static class ValidationErrors{
        public static final String FIELD_NOT_BLANK = "{field.notBlank}";
        public static final String FIELD_NOT_NULL = "{field.notNull}";
    }

    public static class BusinessErrors{
        public static final String CUSTOMER_NATID_EXIST = "customer.NatIdExist";

        public static final String CUSTOMER_NOT_EXIST = "customer.notExist";

        public static final String CUSTOMER_EXIST_WITH_SAME_NATID= "customer.existWithSameNationalityId";

    }
}
