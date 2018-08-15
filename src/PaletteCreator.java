




//Class which serves for creating the appropriate tool class
public class PaletteCreator
{
    /**************************************************************************************************************
     *****************************************************VARIABLES************************************************
     **************************************************************************************************************/
    private static Palette pencillTool;
    
    private static Palette lineTool;
    private static Palette currentTool;

    public static final int PENCILL_TOOL= 1;
    public static final int LINE_TOOL= 2;
   
    /**************************************************************************************************************
     *************************************************FACTORY METHOD***********************************************
     **************************************************************************************************************/
    /**
     * Creates a new instance of the Tool (depending on the given parameter), passing in the tool type parameter
     * Sets the  currentTool view to that of the newly created class
     * @param toolTYpe  String parameter defining the type of the tool that is to be created
     * @return   currentTool
     */
    public static Palette createTool(int toolTYpe)
    {
        switch (toolTYpe)
        {
           
            case 1 :   if (pencillTool == null  )
                pencillTool =  new Palette(PENCILL_TOOL);
                currentTool = pencillTool;
                break;
           
            case 2 :   if (lineTool == null)
                lineTool =  new Palette(LINE_TOOL);
                currentTool = lineTool;
                break;
            
           
        }
        return currentTool;
    }
}
