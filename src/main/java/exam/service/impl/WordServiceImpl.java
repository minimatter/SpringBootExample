package exam.service.impl;

import exam.bean.Department;
import exam.bean.Indent;
import exam.dao.WordDao;
import exam.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WordServiceImpl implements IWordService {
    @Autowired
    private WordDao wordDao;

    @Override
    public List<Indent> queryIndent(Map<String, Object> map) {
        return wordDao.queryIndent(map);
    }

    @Override
    public List<Department> queryDP() {
        return wordDao.queryDP();
    }

    @Override
    public int insertIndent(Indent indent) {
        return wordDao.insertIndent(indent);
    }

    @Override
    public int updateIndent(Indent indent) {
        return wordDao.updateIndent(indent);
    }

    @Override
    public int deleteIndent(int id) {
        return wordDao.deleteIndent(id);
    }
}
