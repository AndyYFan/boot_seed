package nju.fanyy;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by fanyunyi on 2017/3/5.
 */
@Component
@ConfigurationProperties(prefix = "file")
public class FileSettings {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
