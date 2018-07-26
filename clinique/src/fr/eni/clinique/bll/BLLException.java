package fr.eni.clinique.bll;

@SuppressWarnings("serial")
public class BLLException extends Exception {
	//Constructors
	public BLLException(){
		super();
	}
	
	public BLLException(String message){
		super(message);
	}
	
	public BLLException(String message, Throwable exception) {
		super(message, exception);
	}
	
	//Methods
		@Override
		public String getMessage() {
			StringBuffer sb = new StringBuffer("Couche DAL - ");
			sb.append(super.getMessage());
			
			return sb.toString() ;
		}
		
}
