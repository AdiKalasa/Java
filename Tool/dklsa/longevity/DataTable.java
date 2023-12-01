package dklsa.longevity;

public class DataTable{
    protected String[] data;
    protected String dataTitle;
    public DataTable(String title, String[] data){
        this.dataTitle = title;
        this.data = data;
    }
    public DataTable(String title, int[] data, String format){
        String[] datastr = Tool.toStringArray(data, format);
        this.dataTitle = title;
        this.data = datastr;
    }
    public DataTable(String title, int[] data){
        String[] datastr = Tool.toStringArray(data);
        this.dataTitle = title;
        this.data = datastr;
    }
}