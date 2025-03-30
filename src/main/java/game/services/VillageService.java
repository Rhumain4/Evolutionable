package game.services;

import game.interfaces.VillageServiceInterface;
import game.models.*;
import game.models.enums.CellType;

import java.util.List;

public class VillageService implements VillageServiceInterface {

    /**
     * Construit un bâtiment dans le village et met à jour les cellules.
     *
     * @param village  Le village où construire le bâtiment.
     * @param cells    La liste des cellules représentant le monde.
     * @param building Le bâtiment à construire.
     * @param startX   Coordonnée X de départ pour la construction.
     * @param startY   Coordonnée Y de départ pour la construction.
     * @param width    Largeur du bâtiment.
     * @param height   Hauteur du bâtiment.
     * @return true si le bâtiment a été construit, false sinon.
     */
    public boolean buildBuilding(Village village, List<Cell> cells, Building building, int startX, int startY, int width, int height) {
        // Vérifier si le bâtiment peut être placé dans les limites
        for (int x = startX; x < startX + width; x++) {
            for (int y = startY; y < startY + height; y++) {
                if (!isCellAvailable(cells, x, y)) {
                    // Si une cellule est déjà occupée, annuler la construction
                    return false;
                }
            }
        }

        // Mettre à jour les cellules
        for (int x = startX; x < startX + width; x++) {
            for (int y = startY; y < startY + height; y++) {
                for (Cell cell : cells) {
                    if (cell.getX() == x && cell.getY() == y) {
                        cell.setVillage(village); // Associer la cellule au village
                        cell.setCellType(CellType.OCCUPIED); // Marquer comme occupée
                    }
                }
            }
        }

        // Ajouter le bâtiment au village
        village.addBuilding(building);
        return true;
    }

    /**
     * Vérifie si une cellule est disponible pour construire un bâtiment.
     *
     * @param cells La liste des cellules.
     * @param x     Coordonnée X de la cellule.
     * @param y     Coordonnée Y de la cellule.
     * @return true si la cellule est disponible, false sinon.
     */
    private boolean isCellAvailable(List<Cell> cells, int x, int y) {
        for (Cell cell : cells) {
            if (cell.getX() == x && cell.getY() == y && cell.getCellType() != CellType.EMPTY) {
                return false;
            }
        }
        return true;
    }
}
