package org.example.MoodAnalyser;

public class MoodAnalyserException extends Exception {
    public exceptionType type;

    public MoodAnalyserException(exceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public MoodAnalyserException(exceptionType type, Throwable cause) {
        super(cause);
        this.type = type;
    }

    public MoodAnalyserException(exceptionType type, String messgae, Throwable cause) {
        super(messgae);
        new MoodAnalyserException(type, cause);
    }

    public enum exceptionType {
        ENTERED_EMPTY, ENTERED_NULL, NO_SUCH_CLASS, NO_SUCH_METHOD,
        METHOD_INVOCATION_ISSUE, NO_SUCH_FIELD, ILLIGAL_ACCESS
    }
}