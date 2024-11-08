package dev.mandevilla.tasks.service.constants

class TaskConstants private constructor() {
    object SharedKeys {
        const val TOKEN = "tokenkey"
        const val PERSON_KEY = "personkey"
        const val PERSON_NAME = "personname"
    }

    object Header {
        const val TOKEN_KEY = "token"
        const val PERSON_KEY = "personkey"
    }

    object Http {
        const val SUCCESS = 200
    }

    object Bundle {
        const val TASKID = "taskid"
        const val TASKFILTER = "taskfilter"
    }

    object Filter {
        const val ALL = 0
        const val NEXT = 1
        const val EXPIRED = 2
    }

}