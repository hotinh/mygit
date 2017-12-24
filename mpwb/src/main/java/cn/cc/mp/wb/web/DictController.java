package cn.cc.mp.wb.web;

import cn.cc.mp.wb.core.Result;
import cn.cc.mp.wb.core.ResultGenerator;
import cn.cc.mp.wb.model.Dict;
import cn.cc.mp.wb.service.DictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2017/12/24.
*/
@RestController
@RequestMapping("/dict")
public class DictController {
    @Resource
    private DictService dictService;

    @PostMapping
    public Result add(@RequestBody Dict dict) {
        dictService.save(dict);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        dictService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody Dict dict) {
        dictService.update(dict);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Dict dict = dictService.findById(id);
        return ResultGenerator.genSuccessResult(dict);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Dict> list = dictService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
