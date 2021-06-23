package com.cognizant.ptaresourcesharingservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity()
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String author;
    private String title;
    private String content;
    private List<Integer> commentIdList;

    public Resource() {
        commentIdList = new ArrayList<>();
    }

    public Resource(int id, String author, String title, String content, List<Integer> commentIdList) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.commentIdList = commentIdList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Integer> getCommentIdList() {
        return commentIdList;
    }

    public void setCommentIdList(List<Integer> commentIdList) {
        this.commentIdList = commentIdList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return id == resource.id && Objects.equals(author, resource.author) && Objects.equals(title, resource.title) && Objects.equals(content, resource.content) && Objects.equals(commentIdList, resource.commentIdList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, content, commentIdList);
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", commentIdList=" + commentIdList +
                '}';
    }
}
