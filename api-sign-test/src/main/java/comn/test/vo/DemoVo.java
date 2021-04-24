package comn.test.vo;

import com.github.xjs.api.sign.ApiSignAble;
import com.github.xjs.api.sign.ApiSignField;


/**
 * @author jiashuai.xu
 * @date 2021/4/19 2:53 下午
 */
public class DemoVo implements ApiSignAble {

    @ApiSignField(1)
    private String name;

    @ApiSignField(2)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    ///////////////////
    private String apiSign;

    private String apiRnd;

    private Long apiTimestamp;

    @Override
    public String getApiSign() {
        return apiSign;
    }

    public void setApiSign(String apiSign) {
        this.apiSign = apiSign;
    }

    @Override
    public String getApiRnd() {
        return apiRnd;
    }

    public void setApiRnd(String apiRnd) {
        this.apiRnd = apiRnd;
    }

    @Override
    public Long getApiTimestamp() {
        return apiTimestamp;
    }

    public void setApiTimestamp(Long apiTimestamp) {
        this.apiTimestamp = apiTimestamp;
    }
}
