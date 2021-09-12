package com.faizi.school.common;

public class WebConstant {

    public static final String VERSION = "/v1";
    public static final String BASE_PATH = "/school";
    public static final String CONTEXT_PATH = VERSION + BASE_PATH;

    public class COURSE {
        public static final String ROOT = CONTEXT_PATH + "/course";
        public static final String PARAM = "/{id}";

        private COURSE() {
        }
    }

    public class STUDENT {
        public static final String ROOT = CONTEXT_PATH + "/student";
        public static final String LIST = "/list";
        public static final String PARAM = "/{id}";

        private STUDENT() {
        }
    }

    public class COURSE_CONFIG {
        public static final String ROOT = CONTEXT_PATH + "/course-config";

        private COURSE_CONFIG() {
        }
    }

    public class COURSE_ENROLLMENT {
        public static final String ROOT = CONTEXT_PATH + "/course-enrollment";
        public static final String PARAM = "/{id}";
        public static final String STUDENT = "/student/{student-id}";

        private COURSE_ENROLLMENT() {
        }
    }
}
