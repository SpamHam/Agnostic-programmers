/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DALC.DALCEmergencyStart;
import Utility.ErrorHandler;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kathrine
 */
public class BLLEmergencyStart {
    
    private static BLLEmergencyStart m_instance;
    private DALC.DALCEmergencyStart DALCeStart;
    private final Utility.ErrorHandler Error;
    
    
    
    public static BLLEmergencyStart getInstance() throws SQLServerException{
       if (m_instance == null) {
            m_instance = new BLLEmergencyStart();
        }
        return m_instance;  
    }
    
    private BLLEmergencyStart() throws SQLServerException{
        Error = ErrorHandler.getInstance();
        DALCeStart = DALCEmergencyStart.getInstance();
    }
    
    public void Create(ArrayList<String> timeStamp, int index) throws Exception{
        if(timeStamp.get(index).isEmpty()){
            Error.NotEnougthInfo("creating timestamp");
        }
        DALCeStart.getInstance().Create(index);
        
    }
    
    
    public ArrayList<String> getAll() throws Exception{
        ArrayList<String> res = new ArrayList<>();
        res = DALCeStart.getInstance().read();
        return  res;
    }
    
    
    
}
