import java.io.*;
import java.util.*;

public class familyTree
{
    class Person
    {
        String name;
        ArrayList<Person> parents;
        ArrayList<Person> siblings;
        ArrayList<Person> children;
        int level;
        Person(String s,int level)
        {
            this.level = level;
            name = s;
            parents = new ArrayList<>();
            siblings = new ArrayList<>();
            children = new ArrayList<>();
        }
        void add(String name,String toAdd,String rel,HashSet<String> visited)
        {
            if(visited.contains(name)) return;
            visited.add(name);
            if(this.name.equals(name))
            {
                if(rel.equals("PARENT"))
                {
                    children.add(new Person(toAdd,level-1));
                    children.get(children.size()-1).parents.add(this);
                }
                if(rel.equals("SIBLING"))
                {
                    siblings.add(new Person(toAdd,level));
                    siblings.get(siblings.size()-1).siblings.add(this);
                }
                if(rel.equals("CHILD"))
                {
                    parents.add(new Person(toAdd,level+1));
                    parents.get(parents.size()-1).children.add(this);
                }
            }
            else
            {
                for(Person p : parents) p.add(name, toAdd, rel,visited);
                for(Person p : siblings) p.add(name, toAdd, rel,visited);
                for(Person p : children) p.add(name, toAdd, rel,visited);
            }
        }
        public String toString()
        {
            return name + " " + level;
        }
    }
    public static void main(String[] args) throws Exception {
        new familyTree().run();
    }
    
    public void run() throws Exception {
        Scanner file = new Scanner(new File("FamilyTree.dat"));
        int times = file.nextInt(); file.nextLine();
        ArrayList<String> l = new ArrayList<>();
        while(times-->0)
        {
            l.add(file.nextLine());
        }
        Person root = new Person(l.get(0).split(" ")[0],0);
        for(String s : l)
        {
            String[] k = s.split(" ");
            root.add(k[0],k[2],k[1],new HashSet<>());
        }
        System.out.println(root);
        System.out.println(root.parents);
        System.out.println(root.siblings);
        System.out.println(root.children);
    }
}