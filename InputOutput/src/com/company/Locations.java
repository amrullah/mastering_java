package com.company;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static final Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try (DataOutputStream locFile =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream("locations.dat")))
        ) {
            for (Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                locFile.writeByte(0x1F);
                locFile.writeInt(location.getExits().size() - 1);
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
    }
    static {
        try (Scanner scanner = new Scanner(new FileReader("locations.txt"))){
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // buffered reader is used to reduce the number of disk seeks
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("directions.txt"))) ){
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String direction = scanner.next();
                scanner.skip(scanner.delimiter());
                int destination = Integer.parseInt(scanner.nextLine());
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
