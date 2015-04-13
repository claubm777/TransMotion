package models;

//import java.util.List;
//
///**
// * Created by Asus on 11/04/2015.
// */
//public class Dijkstra {
//
//    public static List<PieceRoute> dijkstraTiempo(){
//        return null;
//    }
//
//    public static List<PieceRoute> dijkstraCongestion(){
//        return null;
//    }
//}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class Dijkstra
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

    public  Double dijkstraCongestionDist(String ninicial,String nfinal) {

        System.out.println("---------------------------ninicial   "+ninicial+"------------nfinal   "+nfinal);
        if (ninicial.startsWith("Universidades")|| ninicial.startsWith("Calle26")|| ninicial.startsWith("Av.39")|| ninicial.startsWith("Calle57")|| ninicial.startsWith("Polo")|| ninicial.startsWith("EscuelaMilitar")|| ninicial.startsWith("Av.68")|| ninicial.startsWith("Granja.Cra77")|| ninicial.startsWith("PortalDeLa80")){
            ninicial=ninicial+"-D70";
        }
        else if(ninicial.startsWith("CentroMemoria")|| ninicial.startsWith("PlazaDeLaDemocracia")|| ninicial.startsWith("CiudadUniversitaria")|| ninicial.startsWith("Corferias")|| ninicial.startsWith("QuintaParedes")|| ninicial.startsWith("Gobernacion")|| ninicial.startsWith("CAN")|| ninicial.startsWith("SalitreElGreco")|| ninicial.startsWith("ElTiempoMaloka")|| ninicial.startsWith("AvRojas")|| ninicial.startsWith("Normandia")|| ninicial.startsWith("Modelia")){
            ninicial=ninicial+"-K6";
        }
        else if(ninicial.startsWith("LasAguas")|| ninicial.startsWith("MuseoDelOro")|| ninicial.startsWith("AvJimenez")|| ninicial.startsWith("Av.39")|| ninicial.startsWith("Calle57")|| ninicial.startsWith("Calle72")|| ninicial.startsWith("Calle76")|| ninicial.startsWith("Heroes")|| ninicial.startsWith("Virrey")|| ninicial.startsWith("Calle100")|| ninicial.startsWith("Prado")|| ninicial.startsWith("Toberin")|| ninicial.startsWith("PortalNorte")|| ninicial.startsWith("Calle142")){
            ninicial=ninicial+"-B74";
        }
        else{
            ninicial=ninicial+"-B16";
        }

        if (nfinal.startsWith("Universidades")|| nfinal.startsWith("Calle26")|| nfinal.startsWith("Av.39")|| nfinal.startsWith("Calle57")|| nfinal.startsWith("Polo")|| nfinal.startsWith("EscuelaMilitar")|| nfinal.startsWith("Av.68")|| nfinal.startsWith("Granja.Cra77")|| nfinal.startsWith("PortalDeLa80")){
            nfinal=nfinal+"-D70";
        }
        else if(nfinal.startsWith("CentroMemoria")|| nfinal.startsWith("PlazaDeLaDemocracia")|| nfinal.startsWith("CiudadUniversitaria")|| nfinal.startsWith("Corferias")|| nfinal.startsWith("QuintaParedes")|| nfinal.startsWith("Gobernacion")|| nfinal.startsWith("CAN")|| nfinal.startsWith("SalitreElGreco")|| nfinal.startsWith("ElTiempoMaloka")|| nfinal.startsWith("AvRojas")|| nfinal.startsWith("Normandia")|| nfinal.startsWith("Modelia")){
            nfinal=nfinal+"-K6";
        }
        else if(nfinal.startsWith("LasAguas")|| nfinal.startsWith("MuseoDelOro")|| nfinal.startsWith("AvJimenez")|| nfinal.startsWith("Av.39")|| nfinal.startsWith("Calle57")|| nfinal.startsWith("Calle72")|| nfinal.startsWith("Calle76")|| nfinal.startsWith("Heroes")|| nfinal.startsWith("Virrey")|| nfinal.startsWith("Calle100")|| nfinal.startsWith("Prado")|| nfinal.startsWith("Toberin")|| nfinal.startsWith("PortalNorte")|| nfinal.startsWith("Calle142")){
            nfinal=nfinal+"-B74";
        }
        else{
            nfinal=nfinal+"-B16";
        }
        System.out.println("---------------------------ninicial   "+ninicial+"------------nfinal   "+nfinal);
        ArrayList<Vertex> nodos = new ArrayList<Vertex>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/nodos.txt"));
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                Vertex v = new Vertex(linea);
                nodos.add(v);
                linea = br.readLine();
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        nodos.remove(nodos.size() - 1);

        try {
            BufferedReader brr = new BufferedReader(new FileReader("./data/tablaentextomatrizcongestion.txt"));
            String linea = brr.readLine();
            linea = brr.readLine();
            int c = 0;
            while (linea != null) {
                System.out.println(linea);
                String[] arreglito = linea.split(";");
                nodos.get(c).adjacencies = new Edge[arreglito.length - 1];
                for (int i = 1; i < arreglito.length; i++) {
                    System.out.println("Nodo inicial: " + nodos.get(c) + " Target: " + nodos.get(i - 1) + "Costo: " + Integer.parseInt(arreglito[i]));
                    nodos.get(c).adjacencies[i - 1] = new Edge(nodos.get(i - 1), Integer.parseInt(arreglito[i]));
                }
                linea = brr.readLine();
                c++;
            }
            brr.close();
        } catch (Exception es) {
            es.printStackTrace();
        }

        for (int i = 0; i < nodos.size(); i++) {
            Vertex v = nodos.get(i);
            System.out.println("--" + i + "---" + v.name);
            for (int j = 0; j < v.adjacencies.length; j++) {
                Edge e = v.adjacencies[j];

            }
        }
        Vertex inicial=new Vertex(ninicial);
        Vertex fin=new Vertex(nfinal);
        for(int i=0;i<nodos.size();i++){
            if(ninicial.equals(nodos.get(i).name))
            {
                inicial=nodos.get(i);
            }
        }
        for(int i=0;i<nodos.size();i++){
            if(nfinal.equals(nodos.get(i).name))
            {
                fin=nodos.get(i);
            }
        }


        computePaths(inicial);
        System.out.println("INICIAL!!!!: " + nodos.get(0));
        List<Vertex> path = getShortestPathTo(fin);
        return fin.minDistance;
//        for (Vertex v : nodos) {
//            System.out.println("Distance to " + v + ": " + v.minDistance);
//            List<Vertex> path = getShortestPathTo(fin);
//            System.out.println("Path: " + path);
//        }
    }

    public static List<String> dijkstraCongestion(String ninicial,String nfinal) {


        if (ninicial.startsWith("Universidades")|| ninicial.startsWith("Calle26")|| ninicial.startsWith("Av.39")|| ninicial.startsWith("Calle57")|| ninicial.startsWith("Polo")|| ninicial.startsWith("EscuelaMilitar")|| ninicial.startsWith("Av.68")|| ninicial.startsWith("Granja.Cra77")|| ninicial.startsWith("PortalDeLa80")){
            ninicial=ninicial+"-D70";
        }
        else if(ninicial.startsWith("CentroMemoria")|| ninicial.startsWith("PlazaDeLaDemocracia")|| ninicial.startsWith("CiudadUniversitaria")|| ninicial.startsWith("Corferias")|| ninicial.startsWith("QuintaParedes")|| ninicial.startsWith("Gobernacion")|| ninicial.startsWith("CAN")|| ninicial.startsWith("SalitreElGreco")|| ninicial.startsWith("ElTiempoMaloka")|| ninicial.startsWith("AvRojas")|| ninicial.startsWith("Normandia")|| ninicial.startsWith("Modelia")){
            ninicial=ninicial+"-K6";
        }
        else if(ninicial.startsWith("LasAguas")|| ninicial.startsWith("MuseoDelOro")|| ninicial.startsWith("AvJimenez")|| ninicial.startsWith("Av.39")|| ninicial.startsWith("Calle57")|| ninicial.startsWith("Calle72")|| ninicial.startsWith("Calle76")|| ninicial.startsWith("Heroes")|| ninicial.startsWith("Virrey")|| ninicial.startsWith("Calle100")|| ninicial.startsWith("Prado")|| ninicial.startsWith("Toberin")|| ninicial.startsWith("PortalNorte")|| ninicial.startsWith("Calle142")){
            ninicial=ninicial+"-B74";
        }
        else{
            ninicial=ninicial+"-B16";
        }

        if (nfinal.startsWith("Universidades")|| nfinal.startsWith("Calle26")|| nfinal.startsWith("Av.39")|| nfinal.startsWith("Calle57")|| nfinal.startsWith("Polo")|| nfinal.startsWith("EscuelaMilitar")|| nfinal.startsWith("Av.68")|| nfinal.startsWith("Granja.Cra77")|| nfinal.startsWith("PortalDeLa80")){
            nfinal=nfinal+"-D70";
        }
        else if(nfinal.startsWith("CentroMemoria")|| nfinal.startsWith("PlazaDeLaDemocracia")|| nfinal.startsWith("CiudadUniversitaria")|| nfinal.startsWith("Corferias")|| nfinal.startsWith("QuintaParedes")|| nfinal.startsWith("Gobernacion")|| nfinal.startsWith("CAN")|| nfinal.startsWith("SalitreElGreco")|| nfinal.startsWith("ElTiempoMaloka")|| nfinal.startsWith("AvRojas")|| nfinal.startsWith("Normandia")|| nfinal.startsWith("Modelia")){
            nfinal=nfinal+"-K6";
        }
        else if(nfinal.startsWith("LasAguas")|| nfinal.startsWith("MuseoDelOro")|| nfinal.startsWith("AvJimenez")|| nfinal.startsWith("Av.39")|| nfinal.startsWith("Calle57")|| nfinal.startsWith("Calle72")|| nfinal.startsWith("Calle76")|| nfinal.startsWith("Heroes")|| nfinal.startsWith("Virrey")|| nfinal.startsWith("Calle100")|| nfinal.startsWith("Prado")|| nfinal.startsWith("Toberin")|| nfinal.startsWith("PortalNorte")|| nfinal.startsWith("Calle142")){
            nfinal=nfinal+"-B74";
        }
        else{
            nfinal=nfinal+"-B16";
        }

        ArrayList<Vertex> nodos = new ArrayList<Vertex>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/nodos.txt"));
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                Vertex v = new Vertex(linea);
                nodos.add(v);
                linea = br.readLine();
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        nodos.remove(nodos.size() - 1);

        try {
            BufferedReader brr = new BufferedReader(new FileReader("./data/tablaentextomatrizcongestion.txt"));
            String linea = brr.readLine();
            linea = brr.readLine();
            int c = 0;
            while (linea != null) {
                System.out.println(linea);
                String[] arreglito = linea.split(";");
                nodos.get(c).adjacencies = new Edge[arreglito.length - 1];
                for (int i = 1; i < arreglito.length; i++) {
                    System.out.println("Nodo inicial: " + nodos.get(c) + " Target: " + nodos.get(i - 1) + "Costo: " + Integer.parseInt(arreglito[i]));
                    nodos.get(c).adjacencies[i - 1] = new Edge(nodos.get(i - 1), Integer.parseInt(arreglito[i]));
                }
                linea = brr.readLine();
                c++;
            }
            brr.close();
        } catch (Exception es) {
            es.printStackTrace();
        }

        for (int i = 0; i < nodos.size(); i++) {
            Vertex v = nodos.get(i);
            System.out.println("--" + i + "---" + v.name);
            for (int j = 0; j < v.adjacencies.length; j++) {
                Edge e = v.adjacencies[j];

            }
        }


        Vertex inicial=new Vertex(ninicial);
        Vertex fin=new Vertex(nfinal);
        for(int i=0;i<nodos.size();i++){
            if(ninicial.equals(nodos.get(i).name))
            {
                inicial=nodos.get(i);
            }
        }
        for(int i=0;i<nodos.size();i++){
            if(nfinal.equals(nodos.get(i).name))
            {
                fin=nodos.get(i);
            }
        }




        computePaths(inicial);
        System.out.println("INICIAL!!!!: " + nodos.get(0));
        List<Vertex> path = getShortestPathTo(fin);
        List<String> path1=new ArrayList<String>();
        for(int i=0;i<path.size();i++){
            path1.add(path.get(i).name);
        }
        return path1;
//        for (Vertex v : nodos) {
//            System.out.println("Distance to " + v + ": " + v.minDistance);
//            List<Vertex> path = getShortestPathTo(fin);
//            System.out.println("Path: " + path);
//        }
    }



    public  Double dijkstraTiempoDist(String ninicial,String nfinal) {

        System.out.println("---------------------------ninicial   "+ninicial+"------------nfinal   "+nfinal);
        if (ninicial.startsWith("Universidades")|| ninicial.startsWith("Calle26")|| ninicial.startsWith("Av.39")|| ninicial.startsWith("Calle57")|| ninicial.startsWith("Polo")|| ninicial.startsWith("EscuelaMilitar")|| ninicial.startsWith("Av.68")|| ninicial.startsWith("Granja.Cra77")|| ninicial.startsWith("PortalDeLa80")){
            ninicial=ninicial+"-D70";
        }
        else if(ninicial.startsWith("CentroMemoria")|| ninicial.startsWith("PlazaDeLaDemocracia")|| ninicial.startsWith("CiudadUniversitaria")|| ninicial.startsWith("Corferias")|| ninicial.startsWith("QuintaParedes")|| ninicial.startsWith("Gobernacion")|| ninicial.startsWith("CAN")|| ninicial.startsWith("SalitreElGreco")|| ninicial.startsWith("ElTiempoMaloka")|| ninicial.startsWith("AvRojas")|| ninicial.startsWith("Normandia")|| ninicial.startsWith("Modelia")){
            ninicial=ninicial+"-K6";
        }
        else if(ninicial.startsWith("LasAguas")|| ninicial.startsWith("MuseoDelOro")|| ninicial.startsWith("AvJimenez")|| ninicial.startsWith("Av.39")|| ninicial.startsWith("Calle57")|| ninicial.startsWith("Calle72")|| ninicial.startsWith("Calle76")|| ninicial.startsWith("Heroes")|| ninicial.startsWith("Virrey")|| ninicial.startsWith("Calle100")|| ninicial.startsWith("Prado")|| ninicial.startsWith("Toberin")|| ninicial.startsWith("PortalNorte")|| ninicial.startsWith("Calle142")){
            ninicial=ninicial+"-B74";
        }
        else{
            ninicial=ninicial+"-B16";
        }

        if (nfinal.startsWith("Universidades")|| nfinal.startsWith("Calle26")|| nfinal.startsWith("Av.39")|| nfinal.startsWith("Calle57")|| nfinal.startsWith("Polo")|| nfinal.startsWith("EscuelaMilitar")|| nfinal.startsWith("Av.68")|| nfinal.startsWith("Granja.Cra77")|| nfinal.startsWith("PortalDeLa80")){
            nfinal=nfinal+"-D70";
        }
        else if(nfinal.startsWith("CentroMemoria")|| nfinal.startsWith("PlazaDeLaDemocracia")|| nfinal.startsWith("CiudadUniversitaria")|| nfinal.startsWith("Corferias")|| nfinal.startsWith("QuintaParedes")|| nfinal.startsWith("Gobernacion")|| nfinal.startsWith("CAN")|| nfinal.startsWith("SalitreElGreco")|| nfinal.startsWith("ElTiempoMaloka")|| nfinal.startsWith("AvRojas")|| nfinal.startsWith("Normandia")|| nfinal.startsWith("Modelia")){
            nfinal=nfinal+"-K6";
        }
        else if(nfinal.startsWith("LasAguas")|| nfinal.startsWith("MuseoDelOro")|| nfinal.startsWith("AvJimenez")|| nfinal.startsWith("Av.39")|| nfinal.startsWith("Calle57")|| nfinal.startsWith("Calle72")|| nfinal.startsWith("Calle76")|| nfinal.startsWith("Heroes")|| nfinal.startsWith("Virrey")|| nfinal.startsWith("Calle100")|| nfinal.startsWith("Prado")|| nfinal.startsWith("Toberin")|| nfinal.startsWith("PortalNorte")|| nfinal.startsWith("Calle142")){
            nfinal=nfinal+"-B74";
        }
        else{
            nfinal=nfinal+"-B16";
        }
        System.out.println("---------------------------ninicial   "+ninicial+"------------nfinal   "+nfinal);
        ArrayList<Vertex> nodos = new ArrayList<Vertex>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/nodos.txt"));
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                Vertex v = new Vertex(linea);
                nodos.add(v);
                linea = br.readLine();
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        nodos.remove(nodos.size() - 1);

        try {
            BufferedReader brr = new BufferedReader(new FileReader("./data/matriztiempo.txt"));
            String linea = brr.readLine();
            linea = brr.readLine();
            int c = 0;
            while (linea != null) {
                System.out.println(linea);
                String[] arreglito = linea.split(";");
                nodos.get(c).adjacencies = new Edge[arreglito.length - 1];
                for (int i = 1; i < arreglito.length; i++) {
                    System.out.println("Nodo inicial: " + nodos.get(c) + " Target: " + nodos.get(i - 1) + "Costo: " + Integer.parseInt(arreglito[i]));
                    nodos.get(c).adjacencies[i - 1] = new Edge(nodos.get(i - 1), Integer.parseInt(arreglito[i]));
                }
                linea = brr.readLine();
                c++;
            }
            brr.close();
        } catch (Exception es) {
            es.printStackTrace();
        }

        for (int i = 0; i < nodos.size(); i++) {
            Vertex v = nodos.get(i);
            System.out.println("--" + i + "---" + v.name);
            for (int j = 0; j < v.adjacencies.length; j++) {
                Edge e = v.adjacencies[j];

            }
        }
        Vertex inicial=new Vertex(ninicial);
        Vertex fin=new Vertex(nfinal);
        for(int i=0;i<nodos.size();i++){
            if(ninicial.equals(nodos.get(i).name))
            {
                inicial=nodos.get(i);
            }
        }
        for(int i=0;i<nodos.size();i++){
            if(nfinal.equals(nodos.get(i).name))
            {
                fin=nodos.get(i);
            }
        }


        computePaths(inicial);
        System.out.println("INICIAL!!!!: " + nodos.get(0));
        List<Vertex> path = getShortestPathTo(fin);
        return fin.minDistance;
//        for (Vertex v : nodos) {
//            System.out.println("Distance to " + v + ": " + v.minDistance);
//            List<Vertex> path = getShortestPathTo(fin);
//            System.out.println("Path: " + path);
//        }
    }

    public static List<String> dijkstraTiempo(String ninicial,String nfinal) {


        if (ninicial.startsWith("Universidades")|| ninicial.startsWith("Calle26")|| ninicial.startsWith("Av.39")|| ninicial.startsWith("Calle57")|| ninicial.startsWith("Polo")|| ninicial.startsWith("EscuelaMilitar")|| ninicial.startsWith("Av.68")|| ninicial.startsWith("Granja.Cra77")|| ninicial.startsWith("PortalDeLa80")){
            ninicial=ninicial+"-D70";
        }
        else if(ninicial.startsWith("CentroMemoria")|| ninicial.startsWith("PlazaDeLaDemocracia")|| ninicial.startsWith("CiudadUniversitaria")|| ninicial.startsWith("Corferias")|| ninicial.startsWith("QuintaParedes")|| ninicial.startsWith("Gobernacion")|| ninicial.startsWith("CAN")|| ninicial.startsWith("SalitreElGreco")|| ninicial.startsWith("ElTiempoMaloka")|| ninicial.startsWith("AvRojas")|| ninicial.startsWith("Normandia")|| ninicial.startsWith("Modelia")){
            ninicial=ninicial+"-K6";
        }
        else if(ninicial.startsWith("LasAguas")|| ninicial.startsWith("MuseoDelOro")|| ninicial.startsWith("AvJimenez")|| ninicial.startsWith("Av.39")|| ninicial.startsWith("Calle57")|| ninicial.startsWith("Calle72")|| ninicial.startsWith("Calle76")|| ninicial.startsWith("Heroes")|| ninicial.startsWith("Virrey")|| ninicial.startsWith("Calle100")|| ninicial.startsWith("Prado")|| ninicial.startsWith("Toberin")|| ninicial.startsWith("PortalNorte")|| ninicial.startsWith("Calle142")){
            ninicial=ninicial+"-B74";
        }
        else{
            ninicial=ninicial+"-B16";
        }

        if (nfinal.startsWith("Universidades")|| nfinal.startsWith("Calle26")|| nfinal.startsWith("Av.39")|| nfinal.startsWith("Calle57")|| nfinal.startsWith("Polo")|| nfinal.startsWith("EscuelaMilitar")|| nfinal.startsWith("Av.68")|| nfinal.startsWith("Granja.Cra77")|| nfinal.startsWith("PortalDeLa80")){
            nfinal=nfinal+"-D70";
        }
        else if(nfinal.startsWith("CentroMemoria")|| nfinal.startsWith("PlazaDeLaDemocracia")|| nfinal.startsWith("CiudadUniversitaria")|| nfinal.startsWith("Corferias")|| nfinal.startsWith("QuintaParedes")|| nfinal.startsWith("Gobernacion")|| nfinal.startsWith("CAN")|| nfinal.startsWith("SalitreElGreco")|| nfinal.startsWith("ElTiempoMaloka")|| nfinal.startsWith("AvRojas")|| nfinal.startsWith("Normandia")|| nfinal.startsWith("Modelia")){
            nfinal=nfinal+"-K6";
        }
        else if(nfinal.startsWith("LasAguas")|| nfinal.startsWith("MuseoDelOro")|| nfinal.startsWith("AvJimenez")|| nfinal.startsWith("Av.39")|| nfinal.startsWith("Calle57")|| nfinal.startsWith("Calle72")|| nfinal.startsWith("Calle76")|| nfinal.startsWith("Heroes")|| nfinal.startsWith("Virrey")|| nfinal.startsWith("Calle100")|| nfinal.startsWith("Prado")|| nfinal.startsWith("Toberin")|| nfinal.startsWith("PortalNorte")|| nfinal.startsWith("Calle142")){
            nfinal=nfinal+"-B74";
        }
        else{
            nfinal=nfinal+"-B16";
        }

        ArrayList<Vertex> nodos = new ArrayList<Vertex>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./data/nodos.txt"));
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                Vertex v = new Vertex(linea);
                nodos.add(v);
                linea = br.readLine();
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        nodos.remove(nodos.size() - 1);

        try {
            BufferedReader brr = new BufferedReader(new FileReader("./data/matriztiempo.txt"));
            String linea = brr.readLine();
            linea = brr.readLine();
            int c = 0;
            while (linea != null) {
                System.out.println(linea);
                String[] arreglito = linea.split(";");
                nodos.get(c).adjacencies = new Edge[arreglito.length - 1];
                for (int i = 1; i < arreglito.length; i++) {
                    System.out.println("Nodo inicial: " + nodos.get(c) + " Target: " + nodos.get(i - 1) + "Costo: " + Integer.parseInt(arreglito[i]));
                    nodos.get(c).adjacencies[i - 1] = new Edge(nodos.get(i - 1), Integer.parseInt(arreglito[i]));
                }
                linea = brr.readLine();
                c++;
            }
            brr.close();
        } catch (Exception es) {
            es.printStackTrace();
        }

        for (int i = 0; i < nodos.size(); i++) {
            Vertex v = nodos.get(i);
            System.out.println("--" + i + "---" + v.name);
            for (int j = 0; j < v.adjacencies.length; j++) {
                Edge e = v.adjacencies[j];

            }
        }


        Vertex inicial=new Vertex(ninicial);
        Vertex fin=new Vertex(nfinal);
        for(int i=0;i<nodos.size();i++){
            if(ninicial.equals(nodos.get(i).name))
            {
                inicial=nodos.get(i);
            }
        }
        for(int i=0;i<nodos.size();i++){
            if(nfinal.equals(nodos.get(i).name))
            {
                fin=nodos.get(i);
            }
        }




        computePaths(inicial);
        System.out.println("INICIAL!!!!: " + nodos.get(0));
        List<Vertex> path = getShortestPathTo(fin);
        List<String> path1=new ArrayList<String>();
        for(int i=0;i<path.size();i++){
            path1.add(path.get(i).name);
        }
        return path1;
//        for (Vertex v : nodos) {
//            System.out.println("Distance to " + v + ": " + v.minDistance);
//            List<Vertex> path = getShortestPathTo(fin);
//            System.out.println("Path: " + path);
//        }
    }


}
