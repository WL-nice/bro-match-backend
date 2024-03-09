package com.wanglei.bromatchback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wanglei.bromatchback.model.domain.Tag;
import com.wanglei.bromatchback.mapper.TagMapper ;
import com.wanglei.bromatchback.service.TagService ;
import org.springframework.stereotype.Service;

/**
* @author master
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2024-03-09 12:50:43
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




