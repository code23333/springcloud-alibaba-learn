package wrh.self.springcloudalibaba.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.seata.spring.annotation.GlobalTransactional;
import wrh.self.springcloudalibaba.entity.User;

public interface UserMapper extends BaseMapper<User> {



    @GlobalTransactional
    void global(User user);

}
