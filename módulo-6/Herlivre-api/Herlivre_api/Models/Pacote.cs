using herlivre_api.Models;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Herlivre_api.Models
{
    [Table("Pacote")]
    public class Pacote
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [ForeignKey("id_voo_1")]
        public Voo Voo_1 { get; set; }

        [ForeignKey("id_voo_2")]
        public Voo Voo_2 { get; set; }

        [ForeignKey("id_registro_aluguel_quarto")]
        public RegistroAluguelQuarto RegistroAluguelQuarto { get; set; }

        [MaxLength(2)]
        public int Total_pessoas { get; set; }

        public Double Valor_original { get; set; }

        public int Desconto { get; set; }

        public Double Valor_promocional { get; set; }

    }
}
