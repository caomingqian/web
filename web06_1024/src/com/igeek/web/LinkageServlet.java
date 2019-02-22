package com.igeek.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igeek.dao.BaseDao;
import com.igeek.domain.Area;

/**
 * Servlet implementation class LinkageServlet
 *//*
@WebServlet("/LinkageServlet")*/
public class LinkageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String state = request.getParameter("state");
		if(state.equals("init")){
			this.initProvince(request,response);
		}else if(state.equals("city")){
			this.initCity(request, response);
		}else if(state.equals("area")){
			this.initArea(request, response);
		}
	}

	protected void initArea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		BaseDao<Area> dao = new BaseDao<Area>();
		//查询所有省跟直辖市
		String sql = "select * from area where area_parent_id=?";
		Object[] params = {cid};
		Object list = dao.getList(sql,params,new Area());
		List<Area> areaList =(List<Area>) list;
		//alert List 嵌套Area类  每一个Area对象代表了一行数据库中的数据
		/**
		 * for(Area sb:println(sb));
		 */
		// json.
		//使用工具  自动将查询结果转换成json格式
		ObjectMapper mapper = new ObjectMapper();
		//将数据转换成json格式
		String json = mapper.writeValueAsString(areaList);
		System.out.println(json);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);
		
	}
	protected void initCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		BaseDao<Area> dao = new BaseDao<Area>();
		//查询所有的直辖市
		String sql = "select * from area where area_parent_id=?";
		Object [] params={pid};
		Object list = dao.getList(sql, params, new Area());
		List<Area> areaList = (List<Area>) list;
		//areaList  List  嵌套Area 类。  每一个Area对象代表了一行数据库中的数据
		/**
		 * for(Area sb:areaList){
		 * 		System.out.println(sb);
		 * }
		 */
		//json.
		//使用工具  自动将查询到的结果转换成json格式
		ObjectMapper mapper = new ObjectMapper();
		//将数据转换成json格式
		String json = mapper.writeValueAsString(areaList);
		//System.out.println(json);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);//
	}
	protected void initProvince(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//???查询所有省 跟直辖市  把查询结果转换成json  out输出这个json。
		BaseDao<Area> dao = new BaseDao<Area>();
		//查询所有省跟直辖市
		String sql = "select * from area where area_parent_id=?";
		Object[] params={0};
		Object list = dao.getList(sql, params, new Area());
		List<Area> areaList = (List<Area>) list;
		//areaList  List  嵌套Area 类。  每一个Area对象代表了一行数据库中的数据
		/**
		 * for(Area sb:areaList){
		 * 		System.out.println(sb);
		 * }
		 */
		//json.
		//使用工具  自动将查询到的结果转换成json格式
		ObjectMapper mapper = new ObjectMapper();
		//将数据转换成json格式
		String json = mapper.writeValueAsString(areaList);
		//System.out.println(json);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);//
	}

}
