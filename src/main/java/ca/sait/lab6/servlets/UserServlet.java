package ca.sait.lab6.servlets;

import ca.sait.lab6.models.Role;
import ca.sait.lab6.models.User;
import ca.sait.lab6.services.RoleService;
import ca.sait.lab6.services.UserService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Melvin Chew
 */
public class UserServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
        RoleService roleService = new RoleService();
        String action = request.getParameter("action");
        String email = request.getParameter("email");

        try{
            List<User> users = userService.getAll();
            request.setAttribute("users", users);
        } catch(Exception e){

        request.setAttribute("error", e.getMessage());
        }

        try{
            List<Role> roles = roleService.getAll();
            request.setAttribute("roles", roles);
        } catch(Exception e){

        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
        }

        if(action != null && action.equals("delete")){
            try{
                userService.delete(email);
            }catch(Exception ex){
                request.setAttribute("error", ex.getMessage());
            }
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
        RoleService roleService = new RoleService();
        String action = request.getParameter("action");

        
        try{
            List<User> users = userService.getAll();
            request.setAttribute("users", users);
        } catch(Exception e){

        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
        }
         try{
            List<Role> roles = roleService.getAll();
            request.setAttribute("roles", roles);
        } catch(Exception e){

        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        if(action != null && action.equals("add")){
            try{
                String email = request.getParameter("addEmail");
                String fName = request.getParameter("addFName");
                String lName = request.getParameter("addLName");
                String password = request.getParameter("addPassword");
                String roleName = request.getParameter("addRole");
             
                int roleID= roleService.getRoleID(roleName);

                userService.insert(email, true, fName, lName, password, new Role(roleID,roleName));      
                
            }catch(Exception ex){
                
                request.setAttribute("error", ex.getMessage());
            }
        }

        if(action != null && action.equals("edit")){
                    try{
                        String email = request.getParameter("editEmail");
                        String fName = request.getParameter("editFName");
                        String lName = request.getParameter("editLName");
                        String password = request.getParameter("editPassword");
                        String roleName = request.getParameter("editRole");

                        int roleID= roleService.getRoleID(roleName);

                        userService.update(email, true, fName, lName, password, new Role(roleID,roleName));      

                    }catch(Exception ex){

                        request.setAttribute("error", ex.getMessage());
                    }
                }

        this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

}