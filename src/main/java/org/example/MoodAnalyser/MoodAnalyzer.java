package org.example.MoodAnalyser;

public class MoodAnalyzer {
        private String message;

        public MoodAnalyzer(String message) {
            this.message = message;
        }

        public String analyseMood(String message) throws MoodAnalyserException {
            this.message = message;
            return analyseMood();
        }

        public String analyseMood() throws MoodAnalyserException {
            try {
                if (message.length() == 0)
                    throw new MoodAnalyserException(MoodAnalyserException.exceptionType.ENTERED_EMPTY, "Please enter Proper Mood");
                if (message.contains("Sad"))
                    return "SAD";
                else
                    return "HAPPY";
            } catch (NullPointerException e) {
                throw new MoodAnalyserException(MoodAnalyserException.exceptionType.ENTERED_NULL, e);
            }
        }

        @Override
        public boolean equals(Object another) {
            MoodAnalyzer mood = (MoodAnalyzer) another;
            return this.message.equals(mood.message);
        }
    }

