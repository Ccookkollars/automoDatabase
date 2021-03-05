package DBConnector;

import com.automo.entity.JobOrder;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class OrderTableModel extends AbstractTableModel {

    private final List<JobOrder> items = new ArrayList<>();
    private final List<Function<JobOrder, ?>> getters = new ArrayList<>();

    public OrderTableModel() {
        addGetters();
    }

    private void addGetters() {
        getters.add(JobOrder::getDateOrderIn);
        getters.add(JobOrder::getOrderStatus);
    }


    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return getters.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return getters.get(columnIndex).apply(items.get(rowIndex));
    }

    public List<JobOrder> getItems() {
        return items;
    }
}
