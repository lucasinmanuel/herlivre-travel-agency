using herlivre_api.Models;
using Microsoft.VisualBasic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Herlivre_api.Models
{
    [Table("Registro_aluguel_quarto")]
    public class RegistroAluguelQuarto
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [ForeignKey("id_quarto")]
        public Quarto Quarto { get; set; }

        public string Data_entrada { get; set; }

        public string Data_saida { get; set; }

    }
}
