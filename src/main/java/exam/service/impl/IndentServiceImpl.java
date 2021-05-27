package exam.service.impl;

import com.github.pagehelper.PageHelper;
import exam.bean.Department;
import exam.bean.Indent;
import exam.dao.IndentDao;
import exam.service.IIndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IndentServiceImpl implements IIndentService {
    @Autowired
    private IndentDao indentDao;

    @Override
    public List<Indent> queryIndent(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return indentDao.queryIndent(null);
    }

    @Override
    public Indent selectIndent(Map<String, Object> map) {
        return indentDao.queryIndent(map).get(0);
    }

    @Override
    public List<Department> queryDepartment() {
        return indentDao.queryDepartment();
    }

    @Override
    public int insertIndent(Indent indent) {
        return indentDao.insertIndent(indent);
    }

    @Override
    public int updateIndent(Indent indent) {
        return indentDao.updateIndent(indent);
    }

    @Override
    public int deleteIndent(int id) {
        return indentDao.deleteIndent(id);
    }
}
