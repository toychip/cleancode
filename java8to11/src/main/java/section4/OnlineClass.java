package section4;

import java.util.Optional;

public class OnlineClass {

    private Integer id;

    private String title;

    private boolean closed;

    public Progress progress;

    // Optional은 return 타입에만 사용하는 것이 권장된다.
    public Optional<Progress> getProgress() {
        // 박스에 담을 때 넣는 것 자체가 null일때 ofNullable을 사용해서 넣는 것이다.
        // return Optional.of(progress); null이 무조건 아닐 떼만 of를 사용할 수 있음. progress가 null이면 NPE가 발생함.
        return Optional.ofNullable(progress);
    }

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}