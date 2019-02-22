# SSM整合

## 基础环境搭建

> 1.创建一个maven工程
>
> 2.引入项目依赖的jar包
>
> 3.引入bootstrap,jquery
>
> 4.创建项目包结构
>
> 5.编写web.xml配置文件
>
> 6.编写sping,springmvc,mybatis配置文件
>
> 7.创建表department,employee
>
> CASCADE：父表delete、update的时候，子表会delete、update掉关联记录；
> SET NULL：父表delete、update的时候，子表会将关联记录的外键字段所在列设为null，所以注意在设计表时外键不能设为not null；
> RESTRICT：如果想要删除父表的记录时，而在子表中有关联该父表的记录，则不允许删除父表中的记录；NO ACTION：同 RESTRICT，也是首先先检查外键；
>
> 8.使用mybatis逆向工程自动生成dao接口以及mapper映射文件
>
> ```xml
> <!-- 注意 不要忘记在接口中添加对应方法。 以及在实体类中配置映射关系。--> 
> <resultMap type="com.igeek.crud.bean.Employee" id="BaseResultMapDept">
>     <id column="e_id" jdbcType="INTEGER" property="eId" />
>     <result column="e_name" jdbcType="VARCHAR" property="eName" />
>     <result column="e_gender" jdbcType="CHAR" property="eGender" />
>     <result column="e_email" jdbcType="VARCHAR" property="eEmail" />
>     <association property="department" javaType="com.igeek.crud.bean.Employee">
>     	<id column="d_id" jdbcType="INTEGER" property="dId" />
>     	<result column="d_name" jdbcType="VARCHAR" property="dName" />
>     </association>
>   </resultMap>
>   
>   <!-- 自己指定查询,带部门信息的查询 -->
>   <sql id="WithDept_Column_List">
>     e.e_id, e.e_name, e.e_gender, e.e_email, d.d_id, d.d_name
>   </sql>
>   <select id="selectByExampleWithDept"  resultMap="BaseResultMapDept">
>     select
>     <if test="distinct">
>       distinct
>     </if>
>     <include refid="WithDept_Column_List" />
>     from employee e left join department on e.d_id = d.d_id
>     <!-- 如果带条件了，会按照指定的条件进行拼接sql -->
>     <if test="_parameter != null">
>       <include refid="Example_Where_Clause" />
>     </if>
>     <if test="orderByClause != null">
>       order by ${orderByClause}
>     </if>
>   </select>
>   
>    <select id="selectByPrimaryKeyWithDept" resultMap="BaseResultMapDept">
>     select 
>     <include refid="Base_Column_List" />
>     from employee e left join department on e.d_id = d.d_id
>     where e_id = #{eId,jdbcType=INTEGER}
>   </select> 
> ```
>
> 