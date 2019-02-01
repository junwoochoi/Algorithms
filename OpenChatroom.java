package algo.Algorithms;


import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42888?language=java
 * 카카오 2019 블라인드 테스트
 * 오픈채팅방 문제
 */
public class OpenChatroom {
    public static void main(String[] args) {
        String[] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        OpenChatroom openChatroom = new OpenChatroom();
        String[] answer = openChatroom.solution(records);
        System.out.println(Arrays.toString(answer));
    }

    public static enum ActionTypes {
        LEAVE, ENTER, CHANGE
    }

    public static class Log {
        private String userId;
        private ActionTypes actionType;

        public Log(String userId, ActionTypes actionType) {
            this.userId = userId;
            this.actionType = actionType;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public ActionTypes getActionType() {
            return actionType;
        }

        public void setActionType(ActionTypes actionType) {
            this.actionType = actionType;
        }
    }


    public String[] solution(String[] records) {
        List<Log> list = new ArrayList<>();
        Map<String, String> userMap = new HashMap<>();
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            String action = st.nextToken();
            String userId = st.nextToken();
            String userNickname = "";
            if (st.hasMoreTokens()) {
                userNickname = st.nextToken();
            }

            if (!userNickname.isEmpty()) {
                userMap.put(userId, userNickname);
            }
            ActionTypes actionType = null;
            switch (action) {
                case "Enter":
                    actionType = ActionTypes.ENTER;
                    break;
                case "Leave":
                    actionType = ActionTypes.LEAVE;
                    break;
                case "Change":
                    actionType = ActionTypes.CHANGE;
                    break;
                default:
                    break;
            }
            list.add(new Log(userId, actionType));
        }
        Vector<String> answer = new Vector<>();
        for (Log log : list) {
            String userId = log.getUserId();
            String nickName = userMap.get(userId);
            if (log.getActionType() == ActionTypes.ENTER) {
                answer.add(nickName + "님이 들어왔습니다.");
            } else if (log.getActionType()== ActionTypes.LEAVE) {
                answer.add(nickName + "님이 나갔습니다.");
            }
        }

        String[] answerStrings = new String[answer.size()];
        int i=0;
        for(String string: answer){
            answerStrings[i] = string;
            i++;
        }

        return answerStrings;
    }
}
