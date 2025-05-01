package projectpharmacy;
public abstract class Item
{
    
    protected String name;
    protected String ID;
    protected int Count;
    Item(){System.out.println("item empty constructor");}
    Item(String name,String ID,int Count){
        this.name=name;
        this.ID=ID;
        this.Count=Count;
       
        
        
    }
     
    
    abstract void Display_Info();
    protected boolean is_av(){
        if(Count>0)return true;
        else return false;
        
    }        
}



 class Liquids extends Item{
     protected double Volume;
     protected String Company;
     Liquids(){System.out.println("liquids empty constructor");}
     Liquids(String name,String ID,int Count,double Volume,String Company){
         super(name,ID,Count);
         this.Volume=Volume;
         this.Company=Company;
     }
     
 
 
 
 @Override
 void Display_Info(){
     
    System.out.println("name:"+name+" ID:"+ID+" Count:"+Count+" Volume:"+Volume+" Company:"+Company);
 
 }
 
 }












class Tablets extends Item{
    int number_capsules;
    
    Tablets(){System.out.println("tablets empty constructor");}
    Tablets(String name,String ID,int Count,int number_capsules){
        super(name,ID,Count);
        this.number_capsules=number_capsules;
    
    }
    
    @Override
    void Display_Info(){
        System.out.println("name:"+name+" ID: "+ID+" Count:"+Count+" number of capsules:"+number_capsules);
        
    }

}
