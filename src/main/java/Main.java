import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_de_usuario();
            }
        });
    }
}

class Interfaz_de_usuario extends JFrame {
    private DataList dataList;
    private JList<Modelado_multidimensional> pairList;
    private JTextField inputField;
    private JTextField filterField;

    public Interfaz_de_usuario() {
        this.dataList = new DataList();

        setLayout(new FlowLayout());

        inputField = new JTextField(20);
        add(inputField);

        JButton addButton = new JButton("Add Pair");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] parts = inputField.getText().split(",");
                int first = Integer.parseInt(parts[0].trim());
                int second = Integer.parseInt(parts[1].trim());
                dataList.addPair(new Modelado_multidimensional(first, second));
                updateList();
            }
        });
        add(addButton);

        JButton modifyButton = new JButton("Modify Selected Pair");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modelado_multidimensional selectedPair = pairList.getSelectedValue();
                if (selectedPair != null) {
                    String[] parts = inputField.getText().split(",");
                    int first = Integer.parseInt(parts[0].trim());
                    int second = Integer.parseInt(parts[1].trim());
                    selectedPair.setFirst(first);
                    selectedPair.setSecond(second);
                    updateList();
                }
            }
        });
        add(modifyButton);

        JButton removeButton = new JButton("Remove Selected Pair");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modelado_multidimensional selectedPair = pairList.getSelectedValue();
                if (selectedPair != null) {
                    dataList.removePair(dataList.getPairs().indexOf(selectedPair));
                    updateList();
                }
            }
        });
        add(removeButton);

        pairList = new JList<>();
        pairList.setPreferredSize(new Dimension(200, 200));
        add(pairList);

        filterField = new JTextField(20);
        add(filterField);

        JButton filterButton = new JButton("Filter");
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filterText = filterField.getText();
                List<Modelado_multidimensional> filteredPairs = dataList.getPairs().stream()
                        .filter(pair -> pair.toString().contains(filterText))
                        .collect(Collectors.toList());
                pairList.setListData(filteredPairs.toArray(new Modelado_multidimensional[0]));
            }
        });
        add(filterButton);

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void updateList() {
        pairList.setListData(dataList.getPairs().toArray(new Modelado_multidimensional[0]));
    }
}

class Modelado_multidimensional {
    private int first;
    private int second;

    public Modelado_multidimensional(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class DataList {
    private List<Modelado_multidimensional> pairs;

    public DataList() {
        this.pairs = new ArrayList<>();
    }

    public void addPair(Modelado_multidimensional pair) {
        this.pairs.add(pair);
    }

    public List<Modelado_multidimensional> getPairs() {
        return pairs;
    }

    public Modelado_multidimensional getPair(int index) {
        return pairs.get(index);
    }

    public void removePair(int index) {
        pairs.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Modelado_multidimensional pair : pairs) {
            sb.append(pair.toString()).append("\n");
        }
        return sb.toString();
    }
}