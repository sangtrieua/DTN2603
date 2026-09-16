package backend.repository.impl;

import backend.repository.IPositionRepository;
import entity.Postion;
import enums.PositionName;
import ultils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPositionRepository {
    @Override
    public boolean kiemTraTonTaiPostionId(Integer positionId) {
        Connection con=null;
        String sql="SELECT 1 FROM dtn2603_testing_system.position WHERE position_id=?;";
        try {
           con= JDBCUtils.getConnection();
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, positionId);
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                return true;
            }
            else {

                return  false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            JDBCUtils.close(con);
        }
    }

    @Override
    public Postion getPostionById(int PostionId) {
        Postion postion = new Postion();
        Connection con=null;
        try {
            con= JDBCUtils.getConnection();
            String sql="SELECT * FROM dtn2603_testing_system.position where position_id=?;";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, PostionId);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                postion.setPostionId(rs.getInt("position_id"));
                String postionName = rs.getString("position_name");
                switch (postionName) {
                    case "DEV": postion.setPositionName(PositionName.DEV); break;
                    case "TEST": postion.setPositionName(PositionName.TEST); break;
                    case "SCRUM_MASTER": postion.setPositionName(PositionName.SCRUM_MASTER); break;
                    case "PM": postion.setPositionName(PositionName.PM); break;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
        return  postion;
    }

    @Override
    public List<Postion> getPostions() {
        List<Postion> postions = new ArrayList<>();
        Connection con=null;
        try {
            con= JDBCUtils.getConnection();
            String sql="SELECT * FROM dtn2603_testing_system.position;";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                Postion postion = new Postion();
                postion.setPostionId(rs.getInt("position_id"));
                String postionName = rs.getString("position_name");
                switch (postionName) {
                    case "DEV": postion.setPositionName(PositionName.DEV); break;
                    case "TEST": postion.setPositionName(PositionName.TEST); break;
                    case "SCRUM_MASTER": postion.setPositionName(PositionName.SCRUM_MASTER); break;
                    case "PM": postion.setPositionName(PositionName.PM); break;
                }
                postions.add(postion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {JDBCUtils.close(con);}
        return  postions;

    }
}
