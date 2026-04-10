import { CommentaireDto } from "./commentaire.dto";
import { ThemesDto } from "./themes.dto";

export interface ArticleDetailDto {
  id: number;
  titre: string;
  contenu: string;
  auteur: string;
  datePublication: Date;
  themeDtos: ThemesDto;
  commentaires: CommentaireDto[];
}