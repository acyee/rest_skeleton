package demo;

import org.springframework.data.annotation.Id;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Anthony on 5/20/16.
 */


@XmlRootElement
public class Demo {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    private Integer id;
}
