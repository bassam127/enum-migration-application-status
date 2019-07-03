package MigrationApplicationStatus.MigrationApplicationStatus;

public enum ApplicationStatus {
	
	BESLUT_GODKAND("godkänd" , "beslut godkänd" , "ni fått positiv beslut grattis" , null),
	ANSOKA_LAMNA_TILLBAKA ("Lämna tillbaka" , "lämna tillbaka" , "ansöka ej godkänd " , null ),
	MIGRATIONSVERKET_BESLUT_PAGOR("beslut" , "beslut pågår" , "migrationsverket besluter om du få svensk medborgarskap" , new ApplicationStatus[] {BESLUT_GODKAND , ANSOKA_LAMNA_TILLBAKA}),
	MIGRATIONSVERKET_KONTROLLERA("kontroll" , "Kontrolera info" , "Kontrolera info i ansoka" , new ApplicationStatus[] {MIGRATIONSVERKET_BESLUT_PAGOR }),
	ANSOKA_TAS_MIGRATIONSVERKET("Ansöka" , "pågående" , "ansöka pågår" , new ApplicationStatus[] {MIGRATIONSVERKET_KONTROLLERA});
	
	private final String steg;
    private final String status;
    private final String beskrivning;
    private final ApplicationStatus[] nastaStatus;
    private  ApplicationStatus tidigareStatus;
    
    static {
    	ANSOKA_LAMNA_TILLBAKA.tidigareStatus = ANSOKA_TAS_MIGRATIONSVERKET;
    }
    
    private ApplicationStatus(String steg , String status , String beskrivning , ApplicationStatus[] nastaStatus) {
    	this.steg = steg;
    	this.status = status;
    	this.beskrivning = beskrivning;
    	this.nastaStatus = nastaStatus;   	
    }
    
	

    public ApplicationStatus getTidigareStatus() {
		return tidigareStatus;
	}

	public void setTidigareStatus(ApplicationStatus tidigareStatus) {
		this.tidigareStatus = tidigareStatus;
	}

	public String getSteg() {
		return steg;
	}

	public String getStatus() {
		return status;
	}

	public String getBeskrivning() {
		return beskrivning;
	}

	public ApplicationStatus[] getNastaStatus() {
		return nastaStatus;
	}
	
	public static ApplicationStatus getApplicationStauts(String steg , String status) {
		ApplicationStatus[] values = ApplicationStatus.values();
		
		for (ApplicationStatus applicationStatus : values) {
			if(applicationStatus.steg.equals(steg) && applicationStatus.status.equals(status)) {
				return applicationStatus;
			}
		}
		throw new IllegalArgumentException("migration.deklaration.steg{}.status{}" +steg +":"+status);
	}
}
