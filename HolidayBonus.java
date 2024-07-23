public final class HolidayBonus {
    // Constants for bonus amounts
    private static final double HighestBonusSales = 5000.0;
    private static final double LowestBonusSales = 1000.0;
    private static final double OtherBonusSalesTotals = 2000.0;

    // Method to calculate holiday bonuses for each store
    public static double[] calculateHolidayBonus(double[][] data) {
        int numOfRows = data.length;
        double[] bonuses = new double[numOfRows];

        for (int col = 0; col < TwoDimRaggedArrayUtility.getHighestInColumn(data, col); col++) {
            int highestColumnIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            int lowestColumnIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);

            for (int row = 0; row < numOfRows; row++) {
                if (col >= data[row].length) {
                    continue; // Skip if column index is out of bounds for this row
                }
                double rowValue = data[row][col];

                if (rowValue <= 0) {
                    bonuses[row] += 0; 
                } else if (row == highestColumnIndex) {
                    bonuses[row] +=HighestBonusSales; 
                } else if (row == lowestColumnIndex) {
                    bonuses[row] += LowestBonusSales; 
                } else {
                    bonuses[row] += OtherBonusSalesTotals; 
                }
            }
        }

      
        int storesWithSales = 0;
        for (double bonus : bonuses) {
            if (bonus > 0) {
                storesWithSales++;
            }
        }
        if (storesWithSales == 1) {
            for (int i = 0; i < bonuses.length; i++) {
                if (bonuses[i] > 0) {
                    bonuses[i] = HighestBonusSales; // Give the single store the highest bonus
                    break;
                }
            }
        }

        return bonuses;
    }

    // Method to calculate total of all holiday bonuses for the district
    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0.0;
        double[] bonuses = calculateHolidayBonus(data);

        for (double bonus : bonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }
}