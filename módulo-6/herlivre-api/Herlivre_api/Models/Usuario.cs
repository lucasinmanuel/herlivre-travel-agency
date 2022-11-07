using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Herlivre_api.Models
{
    [Table("Usuario")]
    public class Usuario
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [ForeignKey("id_cargo")]
        public Cargo Cargo { get; set; }

        [StringLength(50)]
        public string Nome { get; set; }

        [StringLength(20)]
        public string Cpf { get; set; }

        [StringLength(30)]
        public string Email { get; set; }

        public string Password { get; set; }
    }
}
