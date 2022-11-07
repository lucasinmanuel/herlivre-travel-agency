using herlivre_api.Models;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Herlivre_api.Models
{
    [Table("Quarto")]
    public class Quarto
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [ForeignKey("id_hotel")]
        public Hotel Hotel { get; set; }

        [MinLength(101)]
        public int Numero { get; set; }

        public Double Valor { get; set; }

        public int Diaria { get; set; }

        public int Qtd_camas { get; set; }

        public int Qtd_assentos_disp { get; set; }

        public string Tipo { get; set; }

    }
}
