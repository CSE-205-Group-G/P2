//**************************************************************************************************
// CLASS: OnCampusStudent
//
// DESCRIPTION
// Direct subclass of Student and calculates costs for an on campus student.
//
//
// GROUP: G
// AUTHOR 1: Addison Corey, tjcorey, addison.corey@asu.edu
// AUTHOR 2: Keatyn Garton, kgarton, kgarton@asu.edu
// AUTHOR 3: Jonathan Kilgore, jpkilgor, jpkilgor@asu.edu
//**************************************************************************************************
public class OnCampusStudent extends Student {

    protected static final int RESIDENT = 1;
    protected static final int NON_RESIDENT = 2;

    private int mResident;

    private double mProgramFee;

    /**
     * OnCampusStudent(String, String, String)
     *
     * Constructor for OnCampusStudent objects
     *
     * @param pId the student's id stored as a String
     * @param pFname the student's first name stored as a String
     * @param pLname the student's last name stored as a String
     */
    public OnCampusStudent(String pId, String pFname, String pLname) {
        super(pId, pFname, pLname);
    }

    /**
     * calcTuition()
     *
     * Calculates the student's tuition based on current rates and residency status
     */
    @Override
    public void calcTuition() {
        double t;

        if (getResidency() == RESIDENT) {
            t = TuitionConstants.ONCAMP_RES_BASE;
        } else {
            t = TuitionConstants.ONCAMP_NONRES_BASE;
        }

        t += getProgramFee();

        if (getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS) {
            t += ((getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS);
        }

        setTuition(t);
    }

    /**
     * getProgramFee()
     *
     * Accessor method for student's program fee
     *
     * @return program fee as a double
     */
    public double getProgramFee() {
        return mProgramFee;
    }

    /**
     * getResidency()
     *
     * Accessor method for student's residency status
     *
     * @return residency status as an int (1 for Resident, 2 for Non-Resident)
     */
    public int getResidency() {
        return mResident;
    }


    /**
     * setProgramFee(double)
     *
     * Mutator method to set student's program fee
     *
     * @param pProgramFee student's program fee rate as a double
     */
    public void setProgramFee(double pProgramFee) {
        mProgramFee = pProgramFee;
    }

    /**
     * setResidency(int)
     *
     * Mutator method to set student's residency status (RESIDENT = 1, NON_RESIDENT = 2)
     *
     * @param pResidency static instance variables RESIDENT or NON_RESIDENT
     */
    public void setResidency(int pResidency) {
        mResident = pResidency;
    }

}