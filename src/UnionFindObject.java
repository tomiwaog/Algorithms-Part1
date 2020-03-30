import java.util.HashMap;

public class UnionFindObject {
    private final People[] object;
    private HashMap<String, String> teamMap;
    private HashMap<String, Integer> teamSize;
    private int totalTeam;

    public UnionFindObject(People[] people) {
        object = people;
        teamMap = new HashMap<>();
        teamSize = new HashMap<>();
        totalTeam = people.length;
        for (People person : object) {
            teamMap.put(person.getName(), person.getName());
            teamSize.put(person.getName(), 1);
        }
    }

    boolean isConnected(String p1, String p2) {
        return (findTeam(p1).equals(findTeam(p2)));
    }

    String findTeam(String person) {
        String member = person;
        while (teamMap.get(member) != member) {
            String parent = teamMap.get(member);
            // teamMap.put(member, parent); // Path optimisation
            member = parent;
        }
        return member;
    }

    void joinTeam(People p1, People p2) {
        String teamP1 = findTeam(p1.getName());
        String teamP2 = findTeam(p2.getName());

        if (isConnected(teamP1, teamP2))
            return;

        int addBothSizes = teamSize.get(teamP2) + teamSize.get(teamP1);
        if (teamSize.get(teamP1) <= teamSize.get(teamP2)) {
            teamMap.put(teamP1, teamP2);
            teamSize.put(teamP2, addBothSizes);
        } else {
            teamMap.put(teamP2, teamP1);
            teamSize.put(teamP1, addBothSizes);
        }
        totalTeam--; // component deduction
    }

    int getNumTeams() {
        return totalTeam;
    }

    public static void main(String[] args) {
        People tom = new People("Tom");
        People titi = new People("Titi");
        People lolade = new People("Lolade");
        People funmi = new People("Funmi");
        People hiya = new People("Hiya");

        UnionFindObject unionPeople = new UnionFindObject(new People[] { tom,
                titi, lolade, funmi, new People("Hiya") });

        unionPeople.joinTeam(funmi, hiya);
        unionPeople.joinTeam(new People("Hiya"), titi);
        unionPeople.joinTeam(tom, hiya);
        unionPeople.joinTeam(hiya, lolade);

        System.out.println("tom root: " + unionPeople.findTeam(tom.getName()));
        System.out
                .println("fun root: " + unionPeople.findTeam(funmi.getName()));
        System.out
                .println("titi root: " + unionPeople.findTeam(titi.getName()));
        System.out.println("lolade root: "
                + unionPeople.findTeam(lolade.getName()));
        System.out.println("titi funmi connected?: "
                + unionPeople.isConnected(funmi.getName(), titi.getName()));
        System.out.println("lolade titi connected?: "
                + unionPeople.isConnected(lolade.getName(), titi.getName()));

    }
}

class People {
    private String name;

    People(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}