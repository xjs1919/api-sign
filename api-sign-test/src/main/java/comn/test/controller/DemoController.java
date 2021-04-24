package comn.test.controller;

import com.github.xjs.api.sign.ApiSignCheck;
import comn.test.vo.DemoVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiashuai.xu
 * @date 2021/4/19 2:52 下午
 */
@RestController
public class DemoController {

    @PostMapping("/demo")
    @ApiSignCheck
    public String demo(@RequestBody  DemoVo demoVo){
        return demoVo.getName()+","+demoVo.getAge();
    }

}

