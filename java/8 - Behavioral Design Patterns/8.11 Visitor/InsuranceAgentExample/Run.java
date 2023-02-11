interface Building {
    void accept(InsuranceAgent agent);
}

class ResidentialBuilding implements Building {
    private int numberOfApartments;

    public ResidentialBuilding(int numberOfApartments) {
        this.numberOfApartments = numberOfApartments;
    }

    public int getNumberOfApartments() {
        return numberOfApartments;
    }

    @Override
    public void accept(InsuranceAgent agent) {
        agent.visit(this);
    }
}

class CommercialBuilding implements Building {
    private int numberOfFloors;

    public CommercialBuilding(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    @Override
    public void accept(InsuranceAgent agent) {
        agent.visit(this);
    }
}

interface InsuranceAgent {
    void visit(ResidentialBuilding residentialBuilding);

    void visit(CommercialBuilding commercialBuilding);
}

class HomeInsuranceAgent implements InsuranceAgent {
    private int residentialBuildingsVisited;

    public int getResidentialBuildingsVisited() {
        return residentialBuildingsVisited;
    }

    @Override
    public void visit(ResidentialBuilding residentialBuilding) {
        residentialBuildingsVisited++;
        System.out.println("Offering home insurance to residential building with "
                + residentialBuilding.getNumberOfApartments() + " apartments");
    }

    @Override
    public void visit(CommercialBuilding commercialBuilding) {
        System.out.println("Sorry, I don't offer insurance for commercial buildings");
    }
}

class BusinessInsuranceAgent implements InsuranceAgent {
    private int commercialBuildingsVisited;

    public int getCommercialBuildingsVisited() {
        return commercialBuildingsVisited;
    }

    @Override
    public void visit(ResidentialBuilding residentialBuilding) {
        System.out.println("Sorry, I don't offer insurance for residential buildings");
    }

    @Override
    public void visit(CommercialBuilding commercialBuilding) {
        commercialBuildingsVisited++;
        System.out.println("Offering business insurance to commercial building with "
                + commercialBuilding.getNumberOfFloors() + " floors");
    }
}

public class Run {
    public static void main(String[] args) {
        Building[] buildings = new Building[] { new ResidentialBuilding(5), new CommercialBuilding(10) };
        HomeInsuranceAgent homeInsuranceAgent = new HomeInsuranceAgent();
        BusinessInsuranceAgent businessInsuranceAgent = new BusinessInsuranceAgent();

        for (Building building : buildings) {
            building.accept(homeInsuranceAgent);
            building.accept(businessInsuranceAgent);
        }

        System.out.println("Home Insurance Agent visited " + homeInsuranceAgent.getResidentialBuildingsVisited()
                + " residential building(s)");
        System.out.println("Business Insurance Agent visited " + businessInsuranceAgent.getCommercialBuildingsVisited()
                + " commercial building(s)");
    }
}