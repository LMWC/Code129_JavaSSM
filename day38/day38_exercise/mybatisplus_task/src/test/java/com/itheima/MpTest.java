package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Item;
import com.itheima.mapper.ItemMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = MpTaskApp.class)
public class MpTest {

    @Autowired
    private ItemMapper itemMapper;


    @Test
    public void addItem(){
        Item item = new Item();
        item.setName("华为P51");
        item.setPrice(668800L); //设置价格单位是分
        item.setImage("https://img11.360buyimg.com/n1/s450x450_jfs/t1/198503/3/476/106191/61029696Ee5633f37/f059c1e9ffbadf3c.jpg");
        item.setCategory("手机");
        item.setBrand("华为");
        //将设置时间的内容去掉，执行成功后createTime与updateTime依然会有值
        //item.setCreateTime(new Date());
        //item.setUpdateTime(new Date());
        //下面属性都有默认值，可以不用设置
//        item.setStock(1000);
//        item.setSold(0);
//        item.setCommentCount(0);
//        item.setAD(true);
//        item.setStatus(1);
        //最终sql语句:INSERT INTO tb_item ( name, price, image, category, brand, create_time, update_time ) VALUES ( ?, ?, ?, ?, ?, ?, ? )
        itemMapper.insert(item); //新增
    }

    @Test
    public void offShelf(){
        Item item = new Item();
        item.setId(66L);
        item.setStatus(2); //设置状态为2-下架
        //将设置时间的内容去掉，执行成功后updateTime依然会更新
        //item.setUpdateTime(new Date());//更新修改时间
        //最终的SQL语句:UPDATE tb_item SET status=?, update_time=? WHERE id=?
        itemMapper.updateById(item); //根据ID进行修改
    }

    @Test
    public void editItem(){
        UpdateWrapper<Item> updateWrapper = new UpdateWrapper<>();
        //设置修改条件
        updateWrapper.eq("brand","华为");
        updateWrapper.eq("category","手机");
        //设置修改内容
        updateWrapper.set("price",20000);//单位为分，200元需要换算成分
        updateWrapper.set("stock",100); //库存调至100个
        updateWrapper.set("update_time",new Date()); //记录商品修改时间
        //最终的sql语句为:UPDATE tb_item SET price=?,stock=?,update_time=? WHERE (brand = ? AND category = ?)
        itemMapper.update(null,updateWrapper);
    }

    @Test
    public void testFindByCondition(){
        //虚拟搜索条件，这些条件可有可无
        String brandName = "小米";
        String category = "平板";
        Long minPrice = 100000L; //1000元
        Long maxPrice = 1000000L; //10000元
        //分页参数
        Integer page = 1; //当前页码
        Integer pagesize=2; //每页显示记录条数
        //构建查询条件
        QueryWrapper<Item> wrapper = new QueryWrapper<>();
        wrapper.like(brandName!=null &&!"".equals(brandName),"brand",brandName); // brand like %?%
        wrapper.eq(category!=null && !"".equals(category),"category",category); //category =?
        wrapper.ge(minPrice!=null,"price",minPrice);// price >= minPrice
        wrapper.le(maxPrice!=null,"price",maxPrice); //price <= maxPrice
        //构建按照价格price升序
        wrapper.orderByAsc("price");
        //构建分页对象
        IPage<Item> iPage = new Page<>(page,pagesize);
        iPage = itemMapper.selectPage(iPage,wrapper);
        long total = iPage.getTotal();
        System.out.println("总记录数为:"+total);
        //当前页的列表集合
        List<Item> records = iPage.getRecords();
        for (Item record : records) {
            System.out.println(record);
        }
    }
}
