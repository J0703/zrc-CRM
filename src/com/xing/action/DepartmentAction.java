package com.xing.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xing.domain.Department;
import com.xing.service.AdminService;
import com.xing.service.DepartmentService;
import com.xing.service.PostService;
import com.xing.service.StaffService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by dllo on 17/10/27.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;
    @Autowired
    @Qualifier("staffService")
    private StaffService staffService;
    @Autowired
    @Qualifier("postService")
    private PostService postService;
    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;
    private Department department;

    public String findAllDept(){
        List<Department> departments = departmentService.findAllDept();
        ServletActionContext.getRequest().setAttribute("dps",departments);
        return SUCCESS;
    }

    public String findDepById(){
        Department department2 = departmentService.findDeptById(department.getDepId());
        ServletActionContext.getRequest().setAttribute("dp",department2);
        return SUCCESS;
    }

    public String saveDepartment(){
        for (Department department1 : departmentService.findAllDept()) {
            if (department1.getDepName().equals(department.getDepName())){
                addActionError("这个部门存在了哟");
                return ERROR;
            }
            if (!department1.getDepId().equals(department.getDepId())){
                departmentService.updateDept(department);
                return SUCCESS;
            }

        }
        departmentService.saveInfo(department);
        return SUCCESS;
    }



    @Override
    public Department getModel() {
        department = new Department();
        return department;
    }
}
