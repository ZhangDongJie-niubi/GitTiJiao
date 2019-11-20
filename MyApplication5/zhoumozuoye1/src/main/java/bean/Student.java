package bean;

public class Student {
    private String title;
    private String chapterName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Student(String title, String chapterName) {
        this.title = title;
        this.chapterName = chapterName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "title='" + title + '\'' +
                ", chapterName='" + chapterName + '\'' +
                '}';
    }
}
