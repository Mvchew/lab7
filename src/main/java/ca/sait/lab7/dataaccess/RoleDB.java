package ca.sait.lab7.dataaccess;

import ca.sait.lab7.models.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class RoleDB {

    public List<Role> getAll() throws Exception {
        
    }

public int lookupRoleID(String roleName) throws Exception{
        
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id= -1;
        
        String sql = "SELECT role_id FROM role WHERE role_name=?;";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, roleName);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return id;
    }
}
