package mapper;

import pojo.Brand;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();

    void add(Brand brand);

    Brand selectbyid(int id);

    void  upate(Brand brand);

    void delete(Brand brand);
}
