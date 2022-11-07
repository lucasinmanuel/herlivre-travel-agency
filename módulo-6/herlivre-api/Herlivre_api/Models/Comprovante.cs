using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Herlivre_api.Models
{
    [Table("Comprovante")]
    public class Comprovante
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [ForeignKey("id_registro_aluguel_quarto")]
        public RegistroAluguelQuarto RegistroAluguelQuarto { get; set; }

        [ForeignKey("id_usuario")]
        public Usuario Usuario { get; set; }

        [ForeignKey("id_pacote")]
        public Pacote Pacote { get; set; }

        public string Data_compra { get; set; }
    }
}
